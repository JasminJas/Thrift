/*
package edu.pja.sri.lab07.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ProductCartClient {
	  public static void main(String [] args) {
		    try {
		      TTransport transport;
		     
		      transport = new TSocket("localhost", 9090);
		      transport.open();

		      TProtocol protocol = new  TBinaryProtocol(transport);
		      ProductManager.Client productManagerclient = new ProductManager.Client(protocol);
		      ProductCart.Client cartClient = new ProductCart.Client(protocol);

		      perform(productManagerclient, cartClient);

		      transport.close();
		    } catch (TException x) {
		      x.printStackTrace();
		    } 
		  }

		  private static void perform(ProductManager.Client productManagerclient,  ProductCart.Client cartClient) throws TException {
			  
			  List<Product> allProducts = productManagerclient.getAllProducts();
			  OrderItem it1 = new OrderItem(allProducts.get(0).getId(), 100);
			  cartClient.addItem(it);
			  OrderItem it2 = new OrderItem(allProducts.get(1).getId(), 10);
			  cartClient.addItem(it2);
			  cartClient.placeOrder();
		  }
		}
*/
