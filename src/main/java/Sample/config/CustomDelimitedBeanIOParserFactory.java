package Sample.config;

import java.io.BufferedReader;
import java.io.Reader;
import org.beanio.stream.RecordReader;
import org.beanio.stream.delimited.DelimitedRecordParserFactory;

/**
 * Created by hatimm on 08-11-2016.
 */
public class CustomDelimitedBeanIOParserFactory extends DelimitedRecordParserFactory {
	
	private String customDelimiter;
	
	public String getCustomDelimiter() {
		return customDelimiter;
	}

	public void setCustomDelimiter(String delimiter) {
		this.customDelimiter = delimiter;
	}

	@Override
	public RecordReader createReader(Reader in) throws IllegalArgumentException {

		if (!(in instanceof BufferedReader)) {
			in = new BufferedReader(in);
		}

		final BufferedReader reader = (BufferedReader) in;

		return new CustomRecordReader(reader, customDelimiter);
	}
}