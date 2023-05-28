/// <reference types="cypress" />

describe('Input Forms Tests', () => {
  beforeEach('Navigate to taxer page', () => {
    cy.clearCookies();
    cy.visit('/');
  });

  it('Add cert', () => {
      cy.get('span').click();
      cy.get('.btn-primary').click();
      cy.get('.dropbox').selectFile('cypress/fixtures/cert.cer', { action: 'drag-drop' });
   

      
  
      cy.reload();
      //Check if user data is displayed
      cy.get('.list-group-item').click();
      cy.fixture('cert').then((user) => {
        const values = Object.values(user);
        values.forEach((value) => {
          cy.contains(value).should('be.visible');
        });
      });


    });
  });
