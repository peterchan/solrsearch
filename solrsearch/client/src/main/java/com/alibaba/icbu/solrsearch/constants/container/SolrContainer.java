package com.alibaba.icbu.solrsearch.constants.container;


public class SolrContainer {
	// private static final Logger logger = LoggerFactory
	// .getLogger(SolrContainer.class);
	//
	// /**
	// * 默认SOLR_HOME地址，通过配置文件获得
	// */
	// public static final String DEFAULT_SOLR_SERVER_HOME = PropertiesMgr
	// .getProperty("solrServerHome");
	//
	// private static CoreContainer container;
	//
	// public SolrContainer(String solrServerHome) {
	// if (StringUtils.isNotBlank(solrServerHome)) {
	// File f = new File(solrServerHome, "solr.xml");
	// container = new Initializer().initialize();
	// try {
	// container.load(solrServerHome, f);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// container.setPersistent(true);
	//
	// logger.info("启动搜索server完成！");
	// } else {
	// logger.error("solrServerHome必须给出，不能为空！");
	// }
	// }
	//
	// public SolrContainer() {
	// this(DEFAULT_SOLR_SERVER_HOME);
	// }
	//
	// static class Initializer extends CoreContainer.Initializer {
	// public Initializer() {
	// }
	//
	// @Override
	// public CoreContainer initialize() {
	// return new CoreContainer(new SolrResourceLoader(
	// SolrResourceLoader.locateSolrHome()));
	// }
	// }
	//
	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// new SolrContainer();
	// }
}
