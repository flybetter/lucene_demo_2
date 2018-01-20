package com.cn.company.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

/**
 * IKAnalyzerTest class
 *
 * @author bingyu wu
 *         Date: 2018/1/19
 *         Time: 下午1:52
 */
public class IKAnalyzerTest {
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(IKAnalyzerTest.class);
    @Test
    public void name() throws Exception {
        String text = "lxw的大数据田地 -- lxw1234.com 专注Hadoop、Spark、Hive等大数据技术博客。 北京优衣库";
        Analyzer analyzer = new IKAnalyzer(false);
        StringReader reader = new StringReader(text);
        TokenStream ts = analyzer.tokenStream("", reader);
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
        while(ts.incrementToken()){
            System.out.print(term.toString()+"|");
        }
        analyzer.close();
        reader.close();
    }

    @Test
    public void name2() throws Exception {
        String text = "lxw的大数据田地 -- lxw1234.com 专注Hadoop、Spark、Hive等大数据技术博客。 北京优衣库";

        Configuration configuration = DefaultConfig.getInstance();
        configuration.setUseSmart(true);
        IKSegmenter ik = new IKSegmenter(new StringReader(text), configuration);
        Lexeme lexeme = null;
        while ((lexeme = ik.next()) != null) {
            System.out.print(lexeme.getLexemeText()+"|");
        }
    }

    @Test
    public void name3() throws Exception {
        Set<String> result=new HashSet<>();
        String targetTitle="南京房价止跌首涨！今天官方权威回应2018年楼市走势…你在干什么";
        String dataTitle="南京房价止跌首涨！今天官方权威回应2018年楼市走势…";

        Set<String> targetTitleData=this.getParticle(targetTitle);
        Set<String> dataTitleData=this.getParticle(dataTitle);

        result.addAll(targetTitleData);
        result.retainAll(dataTitleData);
        Double insectionSize=new Double((double)result.size());

        result.clear();
        result.addAll(targetTitleData);
        result.addAll(dataTitleData);

        Double unionSize=new Double((double)result.size());

        logger.info(insectionSize.toString());
        logger.info(unionSize.toString());

        Double dataTitleSize=new Double((double)dataTitleData.size());

        logger.info("Matching Degree:"+ insectionSize/dataTitleSize*100+"%");

    }

    public static Set<String> getParticle(String targetString){

        Set<String> result = new HashSet<String>(10);
        try {
            Configuration configuration = DefaultConfig.getInstance();
            configuration.setUseSmart(true);
            IKSegmenter ik = new IKSegmenter(new StringReader(targetString), configuration);
            Lexeme lexeme = null;
            System.out.println();
            while ((lexeme = ik.next()) != null) {
                System.out.print(lexeme.getLexemeText()+"|");
                result.add(lexeme.getLexemeText());
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }




}
