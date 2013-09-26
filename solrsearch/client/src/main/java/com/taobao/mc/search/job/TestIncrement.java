package com.taobao.mc.search.job;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;

import com.taobao.mc.search.constants.CoreNames;
import com.taobao.mc.search.service.impl.ServerManage;

public class TestIncrement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// HttpSolrServer server = new HttpSolrServer(
			// "http://localhost:8080/search-web/core2/");

			HttpSolrServer server = ServerManage
					.getHttpServer(CoreNames.FILE_FEATURE);
			server.setParser(new XMLResponseParser());
			SolrInputDocument doc1 = new SolrInputDocument();
			doc1.addField("id", "TEST-000011");
			doc1.addField("catalogs_title", "TEST-000011");
			doc1.addField("content", "i am chenwei");

			Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
			docs.add(doc1);
			server.add(docs);
			server.commit();
			System.out.println("Finish!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
