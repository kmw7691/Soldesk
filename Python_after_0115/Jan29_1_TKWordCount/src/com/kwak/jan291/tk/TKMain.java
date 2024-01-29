package com.kwak.jan291.tk;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TKMain {
	public static void main(String[] args) {
		try {
			
			Configuration c = new Configuration();
			Job j = Job.getInstance();
			
			j.setMapperClass(TKMapper.class);
			j.setCombinerClass(TKReducer.class);
			j.setReducerClass(TKReducer.class);
			
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			//파일지정
			String fileName = null;
			for (int i = 0; i <= 10; i++) {
				fileName = String.format("/tk%02d.txt", i);
				FileInputFormat.addInputPath(j, new Path(fileName));
			}
			
			FileOutputFormat.setOutputPath(j, new Path(args[0]));
			
			j.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
