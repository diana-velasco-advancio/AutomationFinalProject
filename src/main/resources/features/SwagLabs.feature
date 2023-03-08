
Feature: Final Automation project
  Scenario: Filter dresses by price Slider
    Given I go to "http://automationpractice.pl/index.php"
    Then I click on Menu "Dresses"
    Then Just wait 5000
    Then I set the filter price
    Then Just wait 10000
    Then I validate the price filter works

  Scenario: Contact us form
    Given I go to "http://automationpractice.pl/index.php"
    Then I click on HeaderMenu "ContactUs"
    Then Just wait 5000
    Then I fill Subject Heading with "Customer Service"
    Then I fill email with "ddm.online@gmail.com"
    Then I fill order reference with "Advancio 54682"
    Then I fill Message Area with "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    Then I fill Selection File with "C:\Users\dianav\testing.txt"
    Then I click on Send button
    Then I validate the data was sent correctly
    Then Just wait 5000


