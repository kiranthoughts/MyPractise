Feature: Product Category on Header
  As a user I want to select product from the category
@productsCategory
  Scenario Outline: Validate ProductLink Redirection

    Given I am on home page "https://www.next.co.uk/"
    When  I click the product link "<categoryChoice>"
    Then I will be redirected appropritely related page "<landingPageTitle>"

    Examples:
    |categoryChoice|landingPageTitle|
    |WOMEN|https://www.next.co.uk/women|
    |MEN|https://www.next.co.uk/men|
    |BEAUTY|https://www.next.co.uk/beauty|
    |BRANDS|ttps://www.next.co.uk/branded|
