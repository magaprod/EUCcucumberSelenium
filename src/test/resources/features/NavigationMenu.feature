@navigate
Feature: Navigation Menu

  Scenario: navigate to  Fleet- Vehicles

  Given the user is on the login page
  And the user enters the sales manager information
  When user navigates to Fleet, Vehicles
  Then the title should be Vehicle

 @db
  Scenario: navigate to Marketing - Campaigns

  Given the user is on the login page
  And the user enters the sales manager information
  When user navigates to Marketing , Campaigns
  Then the title should be Campaigns



  Scenario: navigate to   Activities - Calendar Events

  Given the user is on the login page
  And the user enters the sales manager information
  When user navigates to Activities - Calendar Events
  Then the title should be Calendar Events

