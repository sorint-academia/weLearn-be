package it.sorint.welearnbe;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
//@Import(TestMongoConfig.class)
public class WelearnBeApplicationTests {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	
	
    @Before
    public void setUp() throws Exception {
    	mongoTemplate.dropCollection(WelearnBeApplication.class);
    }

    @After
    public void tearDown() throws Exception {
    	mongoTemplate.dropCollection(WelearnBeApplication.class);
    }

	
	@Test
	public void contextLoads() {
	}

}
