describe('Homepage & login', () => {
    it('Visits my homepage', () => {
        cy.visit('http://localhost:3000/');

        cy.contains("button", "2")
            .click();
    });
});

describe('Table & filters', () => {
    it('Should filter on name', () => {
        cy.visit('http://localhost:3000/coins');

        cy.get('.ant-table-filter-trigger-container')
            .find('span:first')
            .click()
            .get('body > div:nth-child(7) > div > div > div > div > input').should('be.visible')
            .type('Bitcoin')
            .type('{enter}');

        cy.get('#root > div > section > main > div > div > div > div > div > div > div > table')
            .find('.ant-table-row')
            .should('have.length', 3);

        cy.get('.ant-table-filter-trigger-container')
            .find('span:first')
            .click()
            .get('body > div:nth-child(7) > div > div > div > div > input').should('be.visible');

        cy.contains('Reset')
            .click();
    });

    it('should allow to sort on Price', function () {
        cy.contains('Price')
            .click();

        cy.contains('Price')
            .click();

        cy.contains('Price')
            .click();
    });
});