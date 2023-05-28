@Cert
Feature: As a user, I want to be able to add certificate

  Background:
    Given user navigates to "baseUrlTaxer"


  Scenario:user has to be able to Add certificate
    When user click AddBtn
    And add certificates
    Then certificate should be displayed

  Scenario: Added certificate must be saved
    When user click AddBtn
    And add certificates
    And refresh page
    Then certificate should be saved
