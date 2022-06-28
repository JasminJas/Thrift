/*
package edu.pja.sri.lab07.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import edu.pja.sri.lab07.server.handlers.ProductCartHandler;
import edu.pja.sri.lab07.server.handlers.ProductManagerHandler;

// Generated code

public class ProductCartServer {

	  public static ProductCartHandler handlerCart;
	  public static ProductManagerHandler handlerManager;

	  public static ProductCart.Processor processorCart;
	  public static ProductManager.Processor processorManager;

	  public static void main(String [] args) {
	    try {
	      handlerCart = new ProductCartHandler();
	      processorCart = new ProductCart.Processor(handlerCart);

	      Runnable simple = new Runnable() {
	        public void run() {
	          simple(processorCart);
	        }
	      };      
	     
	      new Thread(simple).start();
	    } catch (Exception x) {
	      x.printStackTrace();
	    }
	  }

	  public static void simple(ProductCart.Processor productCartProcessor, ProductManager.Processor productManagerProcessor) {
	    try {
	      TServerTransport serverTransport = new TServerSocket(9090);
	      TServer server = new TSimpleServer(new Args(serverTransport).processor(processorCart));

	      System.out.println("Starting the simple server...");
	      server.serve();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 
	}*/
