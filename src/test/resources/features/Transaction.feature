Feature: Cadastro de lançamento financeiro

  Scenario: Criar lançamento financeiro válido
    Given o payload do lançamento
    When eu enviar uma requisição POST para "/api/transactions"
    Then a resposta deve ter status 200
    And o corpo deve conter o campo "id"
    And o JSON deve seguir o contrato definido