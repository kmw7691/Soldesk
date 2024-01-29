package com.beaver.jan261.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 소설책 -> 작가가 무슨 단어를 자주 사용했는지

// Hadoop : 서버급 (Linux)컴퓨터를 여러대로 병렬처리해서 분석하는 Java프로그램

// Windows : 자동완성하려고...!
//		=> 필요한것만 자동완성되면 OK!
//		=> Hadoop 전체적인건 필요 X
//		=> 실제로 실행 할 Linux에는 Hadoop 전체가 다 설치되어있음
//	=> hadoop-common, hadoop-mapreduce-client-core만 있으면 됨!!!

// Hadoop의 마지막 단계
public class WCMain2 {
	public static void main(String[] args) {
		try {
			// 설정
			Configuration c = new Configuration();
			
			// Hadoop작업을 하겠다 ~ 라고 알리는 객체
			Job j = Job.getInstance(c);
			
			// 각 단계별 담당 클래스 지정
			j.setMapperClass(WCMapper.class); // 이 작업의 Mapper 역할은 ?
			j.setCombinerClass(WCReducer.class); // 이 작업의 Combime 역할은 ?
			j.setReducerClass(WCReducer.class); // 이 작업의 Reduce 역할은 ?
			
			// 결과 형태 - Reduce쪽 뒤에 두개(keyOut, valueOut)와 맞춰서 쓰기
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			// HDFS 최상위에 있는 txt파일을 분석
			FileInputFormat.addInputPath(j, new Path(args[0]));
			
			// 분석해서 그 결과를 HDFS 최상위에 있는 지정한 폴더에 담도록
			FileOutputFormat.setOutputPath(j, new Path(args[1]));
			
			// *** 작업 끝날때까지 대기(필수적으로 명시!!!)
			j.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














