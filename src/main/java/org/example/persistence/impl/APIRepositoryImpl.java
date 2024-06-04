package org.example.persistence.impl;

import org.example.persistence.APIRepository;
import org.example.persistence.entity.*;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class APIRepositoryImpl implements APIRepository {
    private final String xmlFilePath = "C:\\Users\\Denitsa.Goranova\\DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API.xml";

    @Override
    public Optional<APIEntity> getApiDetails(String name)  {
        Optional<APIEntity> entity = Optional.empty();
        return entity;
    }



    @Override
    public List<APIEntity> getAPIS() {
        List<APIEntity> apiEntities = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));
            Element rootElement = document.getDocumentElement();
            NodeList apiNodeList = rootElement.getElementsByTagName("row");

            for (int i = 0; i < apiNodeList.getLength(); i++) {
                Node apiNode = apiNodeList.item(i);

                if (apiNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element apiElement = (Element) apiNode;

                    String description = apiElement.getElementsByTagName("API_DESC").item(0).getTextContent();
                    String version = apiElement.getElementsByTagName("API_VERSION").item(0).getTextContent();
                    String function = apiElement.getElementsByTagName("API_FUNCTION").item(0).getTextContent();
                    String url = apiElement.getElementsByTagName("API_URL").item(0).getTextContent();
                    String type = apiElement.getElementsByTagName("API_TYPE").item(0).getTextContent();
                    String header = apiElement.getElementsByTagName("API_HEADER").item(0).getTextContent();
                    Long id = Long.valueOf((apiElement.getElementsByTagName("API_ID").item(0).getTextContent()));
                    APIEntity apiEntity = new APIEntity(id, function, description, url, type, header, version, new ArrayList<>(), new ArrayList<>(),new ArrayList<>(), new ArrayList<>());

                    List<ResponseParameterEntity> responseParameters = getResponseParameters(id);
                    apiEntity.setResponseParameterEntities(responseParameters);
                    List<RequestParametersEntity> requestParameters = getRequestParameters(id);
                    apiEntity.setRequestParametersList(requestParameters);
                    List<ErrorCodeEntity> errorCodeEntities = getErrorCodes(id);
                    apiEntity.setErrorCodeEntities(errorCodeEntities);
                    List<LanguageEntity> languageEntities = getLanguages(id);
                    apiEntity.setLanguageEntities(languageEntities);
                    apiEntities.add(apiEntity);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return apiEntities;
    }

    private static String getElementTextContent(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                return element.getTextContent();
            }
        }
        return null;
    }

    private List<LanguageEntity> getLanguages(Long apiId)   {

        List<LanguageEntity> languageEntities = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Denitsa.Goranova\\DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_LANGUAGES.xml"));
            Element rootElement = document.getDocumentElement();
            NodeList responseNodeList = rootElement.getElementsByTagName("row");

            for (int i = 0; i < responseNodeList.getLength(); i++) {
                Node responseNode = responseNodeList.item(i);

                if (responseNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element responseElement = (Element) responseNode;

                    Long responseApiId = Long.valueOf(responseElement.getElementsByTagName("API_ID").item(0).getTextContent());
                    if (apiId.equals(responseApiId)) {

                        String example = getElementTextContent(responseElement, "EXAMPLE");
                        String language = getElementTextContent(responseElement, "LANGUAGE");

                        LanguageEntity responseParameter = LanguageEntity.builder().language(language).example(example)
                                .build();
                        languageEntities.add(responseParameter);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return languageEntities;


    }

    private List<ErrorCodeEntity> getErrorCodes(Long apiId)   {
        List<ErrorCodeEntity> errorCodeEntities = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Denitsa.Goranova\\DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_ERROR_CODES.xml"));
            Element rootElement = document.getDocumentElement();
            NodeList responseNodeList = rootElement.getElementsByTagName("row");

            for (int i = 0; i < responseNodeList.getLength(); i++) {
                Node responseNode = responseNodeList.item(i);

                if (responseNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element responseElement = (Element) responseNode;

                    Long responseApiId = Long.valueOf(responseElement.getElementsByTagName("API_ID").item(0).getTextContent());
                    if (apiId.equals(responseApiId)) {

                        String name = getElementTextContent(responseElement, "ERROR_CODE");
                        String possibleReason = getElementTextContent(responseElement, "POSSIBLE_REASON");
                        String description = getElementTextContent(responseElement, "ERROR_DESCRIPTION");
                        Long id = Long.valueOf(responseElement.getElementsByTagName("ID").item(0).getTextContent());


                        ErrorCodeEntity responseParameter = ErrorCodeEntity.builder().errorCode(name).possibleReason(possibleReason)
                                .description(description).build();
                        errorCodeEntities.add(responseParameter);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return errorCodeEntities;
    }

    private List<RequestParametersEntity> getRequestParameters(Long apiId)   {

        List<RequestParametersEntity> requestParametersEntities = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Denitsa.Goranova\\DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_REQUEST_PARAMETERS.xml"));
            Element rootElement = document.getDocumentElement();
            NodeList responseNodeList = rootElement.getElementsByTagName("row");

            for (int i = 0; i < responseNodeList.getLength(); i++) {
                Node responseNode = responseNodeList.item(i);

                if (responseNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element responseElement = (Element) responseNode;

                    Long responseApiId = Long.valueOf(responseElement.getElementsByTagName("API_ID").item(0).getTextContent());
                    if (apiId.equals(responseApiId)) {

                        String name = getElementTextContent(responseElement, "PARAMETER_NAME");
                        String type = getElementTextContent(responseElement, "PARAMETER_TYPE");
                        String description = getElementTextContent(responseElement, "PARAMETER_DESCRIPTION");
                        String example = getElementTextContent(responseElement, "PARAMETER_EXAMPLE");
                        boolean required= Boolean.parseBoolean(getElementTextContent(responseElement, "PARAMETER_REQUIRED"));

                        RequestParametersEntity responseParameter = RequestParametersEntity.builder().parameterName(name).parameterRequired(required).parameterType(type).parameterDescription(description).parameterExample(example).build();
                        requestParametersEntities.add(responseParameter);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return requestParametersEntities;


    }


    private List<ResponseParameterEntity> getResponseParameters(Long apiId)  {
        List<ResponseParameterEntity> responseParameters = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Denitsa.Goranova\\DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_RESPONSE_PARAMETERS.xml"));
            Element rootElement = document.getDocumentElement();
            NodeList responseNodeList = rootElement.getElementsByTagName("row");

            for (int i = 0; i < responseNodeList.getLength(); i++) {
                Node responseNode = responseNodeList.item(i);

                if (responseNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element responseElement = (Element) responseNode;

                    Long responseApiId = Long.valueOf(responseElement.getElementsByTagName("API_ID").item(0).getTextContent());
                    if (apiId.equals(responseApiId)) {
                        Long responseId = Long.valueOf(responseElement.getElementsByTagName("RESPONSE_ID").item(0).getTextContent());

                        String name = getElementTextContent(responseElement, "RESPONSE_PARAMETER_NAME");
                        String type = getElementTextContent(responseElement, "RESPONSE_PARAMETER_TYPE");
                        String description = getElementTextContent(responseElement, "RESPONSE_PARAMETER_DESCRIPTION");
                        String example = getElementTextContent(responseElement, "RESPONSE_PARAMETER_EXAMPLE");
                        List<FeatureEntity> featureEntities = getFeatures(responseId);

                        ResponseParameterEntity responseParameter = ResponseParameterEntity.builder().featureEntities(featureEntities).parameterName(name).id(responseId).parameterType(type).parameterDescription(description).parameterExample(example).build();
//                        responseParameter.setFeatureEntities(featureEntities);
                        responseParameters.add(responseParameter);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return responseParameters;
    }

    private List<FeatureEntity> getFeatures(Long responseId)   {
        List<FeatureEntity> featureEntities = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Denitsa.Goranova\\DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_FEATURES.xml"));
            Element rootElement = document.getDocumentElement();
            NodeList responseNodeList = rootElement.getElementsByTagName("row");

            for (int i = 0; i < responseNodeList.getLength(); i++) {
                Node responseNode = responseNodeList.item(i);

                if (responseNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element responseElement = (Element) responseNode;


                    Long responseID = Long.valueOf(responseElement.getElementsByTagName("RESPONSE_ID").item(0).getTextContent());
                    if (responseId.equals(responseID)) {

                        String name = getElementTextContent(responseElement, "FEATURE_NAME");
                        String type = getElementTextContent(responseElement, "FEATURE_TYPE");
                        String description = getElementTextContent(responseElement, "FEATURE_DESCRIPTION");

                        FeatureEntity feature = FeatureEntity.builder()
                                .featureName(name)
                                .featureType(type)
                                .id(responseId)
                                .featureDescription(description)
                                .build();
                        featureEntities.add(feature);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return featureEntities;


    }
}
