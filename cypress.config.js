const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    baseUrl: 'https://js-55fbfg.stackblitz.io/',
    env: {
      
    },
    video: false,
    retries: 1,
    defaultCommandTimeout: 5000,
    viewportHeight: 800,
    viewportWidth: 1200,
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
