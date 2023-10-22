package com.joel.br.Test.Vol.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.joel.br.Test.Vol.model.Avangers;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

import lombok.Data;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Data
public class CodinomeServices {




    private  final  RestTemplate restTemplate;
    private  final Environment environment;
    private  final ObjectMapper mapper;


    private List<String> avangerss = new ArrayList<>();
    private List<String> justiceLeague = new ArrayList<>();



    @PostConstruct
   public void  loadingJson() {


       try {
           String codinomeResponse = restTemplate.getForObject(environment.getProperty("avangers"), String.class);
           JsonNode jsonNode = mapper.readTree(codinomeResponse);

           ArrayNode arrayNode = (ArrayNode) jsonNode.get("vingadores");


           for(JsonNode e : arrayNode) {
               this.avangerss.add(e.get("codinome").asText());
           }

       }catch (Exception e) {
           e.printStackTrace();
       }

   }
   @PostConstruct
   public void  loadingJsonData() {


       try {
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = factory.newDocumentBuilder();
           Document document = builder.parse(environment.getProperty("justice.league"));


           NodeList nodeList = document.getElementsByTagName("codinome");


           for (int i= 0; i < nodeList.getLength(); i++) {
               Element element = (Element) nodeList.item(i);
               String codinome = element.getTextContent();

               this.justiceLeague.add(codinome);
           }

       }catch (Exception e) {
           e.printStackTrace();
       }

   }
}
