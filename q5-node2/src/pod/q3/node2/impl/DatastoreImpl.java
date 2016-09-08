package pod.q3.node2.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import pod.q3.node2.Datastore;

public class DatastoreImpl implements Datastore {
	private static final String DBNAME = "disk.txt";

	@Override
	public void saveItem(String text) {
		File file = new File(DBNAME);
		try {
			//
			FileOutputStream out = new FileOutputStream(file, true);
			//
			String data = text + "\n";
			out.write(data.getBytes());
			out.flush();
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<String> listItems() {
		//
		List<String> items = new ArrayList<>();
		//
		File file = new File(DBNAME);
		try {
			//
			FileInputStream in = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			//
			String line = null;
			do {
				line = reader.readLine();
				if (line != null)items.add(line);
			}while(line != null);
			//
			reader.close();
			isr.close();
			in.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return items;
	}

}
