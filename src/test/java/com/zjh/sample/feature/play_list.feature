Feature:
  Background: Test play list

    Scenario: Create a new media type
      * def createPayload = read('classpath:com/zjh/sample/data/create_play_list.json')
      * print createPayload
      Given url baseUrl+playListUrl
      And request createPayload
      When method POST
      Then status 200
      And print response
