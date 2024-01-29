package com.beaver.jan261.wc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Hadoop작업의 첫번째 단계 : Map

// 1단계 : 다운받은 소설책을 분석하라고 넣어줄 것 !
//		>> key : 없고, Value : String (hadoop에서는 String이 Text)
// 2단계 : 결과를 받아오기
//		>> key : String, value: int
//		ex) I, 1
//			am, 1
//			sleepy, 1

public class WCMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	// 결과처리를 위해 자료형을 맞추려면 메소드 밖으로 빼서 맞출것
	// 메모리 절약하기 위해서 -> singleton 처리
	private static final Text WORD = new Text();
	private static final IntWritable ONE = new IntWritable(1);
	
	// map을 override >> 한 문장마다 이 method가 호출이 될 것
	@Override
	protected void map(Object key, // data의 유무 체크(별로 중요하지 않음) 
			Text value, // **중요** 그 문장 자체
			// 결과처리용
			Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		// 기존에 사용하던 String 객체로 바꿔주는 작업
		String line = value.toString();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		while (st.hasMoreElements()) { // 반복문 돌려서
			// 결과처리... (Hadoop의 자료형에 맞춰줘야함)
			WORD.set(st.nextToken());
			context.write(WORD, ONE);
		}
	}
}















