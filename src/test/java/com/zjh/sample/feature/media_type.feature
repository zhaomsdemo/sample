Feature: mediaType
  Background: Test media type

    Scenario: Create a new media type
      * def createPayload = read('classpath:com/zjh/sample/data/create_media_type.json')
      * print createPayload
      Given url baseUrl+mediaTypeUrl
      And request createPayload
      When method POST
      Then status 200
      And print response
