Feature: Contacts page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers"  "Contacts"
    Then default page number should be 1


  Scenario: Menu Options Driver
    Given the user logged in as "driver"
    Then the user should see the following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  Scenario: Menu Options Driver
    Given the user logged in as "sales manager"
    Then the user should see the following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |


  Scenario Outline: login as a given user <user>
    Given the user is on the login page
    When  the user logs in using following credentials
      | username  | <username>  |
      | password  | <password>  |
      | firstname | <firstname> |
      | lastname  | <lastname>  |

    Then the user should be able to login
    Examples:
      | username | password    | firstname | lastname |
      | user10   | UserUser123 | John      | Doe      |

