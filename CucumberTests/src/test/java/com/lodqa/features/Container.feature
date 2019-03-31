Feature: count geometry surface and volume

  @surface
  Scenario: Count geometry surface
    Given get test geometry with name square
    When add geometry to container
    And count geometry surface
    Then geometry figure surface equals 100

  @volume
  Scenario Outline: Count geometry volue
    Given get test geometry with name <name>
    When add geometry to container
    And count geometry volume
    Then geometry figure volume equals <result>
    Examples:
      | name     | result |
      | cube     | 125    |
      | cylinder | 300    |