Feature:
  Verify the RequestSpecifications part of the RestAssured

  Scenario: Verify one author  of th post
    Given I perform GET Operations for "/posts"
    Then I should see the  author name as "typicode"
