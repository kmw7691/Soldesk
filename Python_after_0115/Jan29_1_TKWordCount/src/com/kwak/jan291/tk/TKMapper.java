package com.kwak.jan291.tk;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


//IN
//		key : 의미x
//		value : 문장 한줄 한줄..
/////////////////////////////////

//OUT
//		key : 등장인물(이름)
//		value : 1

public class TKMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final Text WHO = new Text();
	private static final IntWritable ONE = new IntWritable(1);
	
	@Override
	protected void map(Object key, 
			Text value,
			Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		StringTokenizer st = new StringTokenizer(value.toString(), " ");
		
		//각각 유비/조조/손권
		String word = null;
		
		while(st.hasMoreElements()) {
			word = st.nextToken();
			//ex)
			//유비는
			//귀가
			//큽니다.
			
			if(word.contains("유비") || word.contains("현덕")) {
				WHO.set("유비");
				context.write(WHO, ONE);
			} else if(word.contains("조조") || word.contains("맹덕")) {
				WHO.set("조조");
				context.write(WHO, ONE);
			} else if(word.contains("손권") || word.contains("중모")) {
				WHO.set("손권");
				context.write(WHO, ONE);
			}
		}
	}
}
