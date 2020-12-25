Feature: Login Functionality

  Background:

    Given siteye gidildi
    When login yapıldı

  Scenario Outline:
    When Go to the contact us page
    Then Send the <Email> and <Message>
    And Success message should display

    Examples:
      | Email               | Message |
      | "aydogan@gmail.com" | "hi"    |
      | "saadet@gmail.com"  | "hi!"   |
      | "osman@gmail.com"   | "hi!!"  |

  Scenario: specials
    When specials i tikla
    Then bir urun sec, sepete ekle ve sepete git
    And speti kontrol et


