package com.icbu.solrsearch;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

import com.alibaba.icbu.solrsearch.SolrServerFactory;
import com.alibaba.icbu.solrsearch.client.SearchClient;
import com.alibaba.icbu.solrsearch.constants.CoreNames;
import com.alibaba.icbu.solrsearch.entity.People;
import com.alibaba.icbu.solrsearch.util.PaginationSupport;

public class TestSearchClient {

    public final static SolrServer CORE_SERVER = SolrServerFactory.getConCurrentServer(CoreNames.CORE3);

    @Test
    public void testCommitObject() {
        People p = new People();
        p.setId("6");
        p.setName("爱情海");
        p.setAge(23);
        p.setSex_prop("女");
        p.setJob_prop("攻城师");
        SearchClient sc = new SearchClient();
        sc.commitObject(p, CORE_SERVER);

    }

    @Test
    public void testCommitList() {
        // TODO Auto-generated method stub
        People p = new People();
        p.setId("2");
        p.setName("刘德华");
        p.setAge(23);

        People p2 = new People();
        p2.setId("3");
        p2.setName("李小龙");
        p2.setAge(60);

        List<People> list = new ArrayList<People>();

        list.add(p);
        list.add(p2);

        SearchClient sc = new SearchClient();

        sc.commitList(list, CORE_SERVER);
        System.out.println("Finish!");

    }

    @Test
    public void testUpdateObject() {

        People p = new People();
        p.setId("4");
        p.setName("黎明");
        p.setAge(46);
        SearchClient sc = new SearchClient();
        sc.update(p, "id", CORE_SERVER);
        System.out.println("Finish!");
    }

    @Test
    public void testQuery() {
        String query = "name:李小龙";
        SolrParams params = new SolrQuery(query);

        SearchClient sc = new SearchClient();
        PaginationSupport<People> ps = sc.query(params, People.class, 0, 10, CORE_SERVER);
        for (People p : ps.getItems()) {
            System.out.println(p.getId() + " " + p.getName());
        }

    }
}
