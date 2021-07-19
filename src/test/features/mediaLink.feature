Feature: MediaLinks
  As a user I should directed to appropriately media link
@mediaLink
  Scenario Outline: Validate media link redirection


    Given user is on home page "https://www.next.co.uk/"
    When user clicks on media link "<mediaLink>"
    Then user should redirected to appropriate media page title "<landingPageTitle>"


    Examples:
      | mediaLink | landingPageTitle |
      | facebook  |https://www.facebook.com/nextofficial|
      | twitter   |https://twitter.com/nextofficial|
      | instagram |https://www.instagram.com|
      | pinterest |https://www.pinterest.co.uk/nextofficial|
      | youtube   |youtube.com|