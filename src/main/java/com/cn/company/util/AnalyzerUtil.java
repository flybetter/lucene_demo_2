package com.cn.company.util;

import com.hankcs.lucene.HanLPAnalyzer;
import org.apache.lucene.analysis.Analyzer;

public class AnalyzerUtil {
	private static Analyzer analyzer = new HanLPAnalyzer();

	public static Analyzer getAnalyzer() {
		return analyzer;
	}
}
