package br.com.vagner.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.vagner.controller.RssFeedController;

public class RssFeedControllerTest {

	@Test
	public void testFeeds() {
		RssFeedController controller = new RssFeedController();
		String retorno = controller.getFeed("https://revistaautoesporte.globo.com/rss/ultimas/feed.xml");
		System.out.println(retorno);
		assertTrue(retorno, true);
	}

}
