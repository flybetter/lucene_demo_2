package com.cn.company.util;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ISUtilPost {
	static Logger log = LoggerFactory.getLogger(ISUtilPost.class);
	private static DirectoryReader reader = null;

	public static DirectoryReader getReader(Directory dir) {
		try {
				reader = getIR(reader, dir);
				return reader;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	private static DirectoryReader getIR(DirectoryReader ir, Directory dir) throws IOException {
			try {
				if (ir == null) {
					ir = DirectoryReader.open(dir);
				} else {
					DirectoryReader newReader = DirectoryReader
							.openIfChanged(ir);
					if (newReader != null) {
						ir = newReader;
					}
				}
				return ir;
			} catch (CorruptIndexException e) {
				log.error(e.getMessage(), e);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
			return null;
	}
}
