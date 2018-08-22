package br.com.vagner.controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.vagner.feed.Feed;
import br.com.vagner.feed.FeedMessage;
import br.com.vagner.model.Description;
import br.com.vagner.model.Item;
import br.com.vagner.service.RSSFeedService;

public class RssFeedController {

	public String getFeed(String url) {
		String jsonInString = null;
		RSSFeedService parser = new RSSFeedService(url);
		Feed feed = parser.readFeed();
		List<Item> items = new ArrayList<Item>();

		for (FeedMessage message : feed.getMessages()) {
			List<Description> descriptions = new ArrayList<Description>();

			try {
				descriptions.addAll(HTMLToJson(message.getDescription()));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Item item = new Item();
			item.setLink(message.getLink());
			item.setTitle(message.getTitle());
			item.setDescription(descriptions);

			items.add(item);

		}
		ObjectMapper mapper = new ObjectMapper();

		try {
			jsonInString = mapper.writeValueAsString(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonInString;
	}

	public static List<Description> HTMLToJson(String source) throws JSONException {
		List<Description> descriptions = new ArrayList<Description>();
		Document doc = Jsoup.parse(source);
		for (Element div : doc.select("div")) {
			for (Element img : div.select("img")) {
				Description d1 = new Description();
				d1.setType(img.tagName());
				d1.setContent(img.attr("src"));
				descriptions.add(d1);

			}

		}

		for (Element text : doc.select("p")) {
			if (text.text().length() > 1) {
				Description d2 = new Description();
				d2.setType("text");
				d2.setContent(text.text().toString());
				descriptions.add(d2);
			}
		}

		for (Element ul : doc.select("ul")) {
			Description d3 = null;
			List<String> hrefs = new ArrayList<String>();
			for (Element li : ul.select("li")) {
				for (Element a : li.select("a")) {
					d3 = new Description();
					d3.setType("links");
					hrefs.add(a.attr("href"));
				}

			}
			d3.setContent(hrefs);
			descriptions.add(d3);
		}

		return descriptions;
	}

}
