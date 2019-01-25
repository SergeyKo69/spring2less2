package ru.kogut.enterprise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kogut.enterprise.models.Client;
import ru.kogut.enterprise.models.Product;
import ru.kogut.enterprise.services.ClientService;
import ru.kogut.enterprise.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Less2ApplicationTests {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ProductService productService;

	@Test
	public void clientTest() {
		Client client = null;
		Client client1 = null;
		try {
			client = new Client();
			client.setTitle("TestTitle");
			client.setAddress("TestAddress");
			client.setDelete(false);
			clientService.saveClient(client);
			Assert.assertNotNull(client.getId());
			client.setTitle("TestTitle2");
			clientService.updateClient(client);
			client1 = clientService.getClientById(client.getId());
			Assert.assertNotNull(client1);
			Assert.assertEquals("TestTitle2",client1.getTitle());
			clientService.deleteClient(client1);
			client1 = clientService.getClientById(client.getId());
			Assert.assertFalse(client1 != null);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if (client != null){
				clientService.deleteClient(client);
			}
			if (client1 != null){
				clientService.deleteClient(client1);
			}
		}

	}

	@Test
	public void productTest(){
		Product product = null;
		Product product1 = null;
		try {
			product = new Product();
			product1 = new Product();
			product.setTitle("ProductTitle");
			product.setDiscription("ProductDiscription");
			product.setDelete(false);
			productService.saveProduct(product);
			Assert.assertNotNull(product.getId());
			product1 = productService.getProductById(product.getId());
			Assert.assertNotNull(product1);
			product.setTitle("ProductTitle1");
			productService.updateProduct(product);
			product1 = productService.getProductById(product.getId());
			Assert.assertNotNull(product1);
			Assert.assertEquals("ProductTitle1", product1.getTitle());
			productService.deleteProduct(product);
			product1 = productService.getProductById(product.getId());
			Assert.assertFalse(product1 != null);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if (product != null){
				productService.deleteProduct(product);
			}
			if (product1 != null){
				productService.deleteProduct(product1);
			}
		}
	}

}

