package Sample.BeanIO;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import Sample.entity.Person;


public class App {
	public static void main(String[] args) {
		new App().readTheData();
	}

	public void readTheData() {
		try {
			StreamFactory factory = StreamFactory.newInstance();
			factory.loadResource("beanio-configuration.xml");

			String str;

			str = FileUtils.readFileToString(new File("src/data/inputData.txt"), "UTF-8");

			BeanReader reader = factory.createReader("Person", new StringReader(str));
			Object record = null;
			List<Person> persons = new ArrayList<Person>();

			while ((record = reader.read()) != null) {
				if ("detail".equals(reader.getRecordName())) {
					Person person = (Person) record;
					persons.add(person);
				}
			}

			System.out.println(persons.get(0).getFirstName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
