package com.zuntech;

import java.io.Serializable;  

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement(name = "user")
public class User implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private int id; 
   private String name; 
   private String address;  
   public User(){} 
    
   public User(int id, String name, String address){  
      this.id = id; 
      this.name = name; 
      this.address = address; 
   }  
   public int getId() { 
      return id; 
   }  
   @XmlElement
   public void setId(int id) { 
      this.id = id; 
   } 
   public String getName() { 
      return name; 
   } 
   @XmlElement
   public void setName(String name) { 
      this.name = name; 
   } 
   public String getAddress() { 
      return address; 
   } 
   @XmlElement
   public void setAddress(String address) { 
      this.address = address; 
   }

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
}   
} 
