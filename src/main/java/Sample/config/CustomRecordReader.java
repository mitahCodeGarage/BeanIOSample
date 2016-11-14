package Sample.config;

import java.io.BufferedReader;
import java.io.IOException;

import org.beanio.stream.RecordIOException;
import org.beanio.stream.RecordReader;

class CustomRecordReader implements RecordReader {
	private String recordText;
	private int lineNumber;
	private BufferedReader reader;
	private String customDelimiter;

	public String getCustomDelimiter() {
		return customDelimiter;
	}

	public void setCustomDelimiter(String delimiter) {
		this.customDelimiter = delimiter;
	}

	public CustomRecordReader(BufferedReader reader, String delimiter) {
		this.reader = reader;
		this.customDelimiter = delimiter;
	}

	public Object read() throws IOException, RecordIOException {

		++lineNumber;
		recordText = reader.readLine();

		return recordText == null ? null : recordText.split(customDelimiter);
	}

	public void close() throws IOException {
		 reader.close(); 
	}

	public int getRecordLineNumber() {
		return lineNumber;
	}

	public String getRecordText() {
		return recordText;
	}
}
	


