import { test, expect } from '@playwright/test';
test.describe("testingUI", () => {
    test.beforeEach(async ({ page }) => {
        await page.goto('http://localhost:8080/');
        await page.locator('input[name="email"]').click();
        await page.locator('input[name="email"]').fill('camel@gmail.com');
        await page.locator('input[name="email"]').press('Tab');
        await page.locator('input[name="password"]').click();
        await page.locator('input[name="password"]').fill('salam123');
        await page.getByRole('button', { name: 'LOGIN' }).click();
    });


    test('Login', async ({ page }) => {

        await page.locator('input[name="email"]').click();
        await page.locator('input[name="email"]').fill('camel@gmail.com');
        await page.locator('input[name="email"]').press('Tab');
        await page.locator('input[name="password"]').click();
        await page.locator('input[name="password"]').fill('salam123');
        await page.getByRole('button', { name: 'LOGIN' }).click();
        await expect(page.getByRole('heading', { name: 'Customer Dashboard' })).toBeVisible();
    });

    test('Add fails', async ({ page }) => {
        await page.goto('http://localhost:8080/');
        await page.locator('input[name="email"]').click();
        await page.locator('input[name="email"]').fill('camel@gmail.com');
        await page.locator('input[name="email"]').press('Tab');
        await page.locator('input[name="password"]').fill('salam123');
        await page.locator('input[name="password"]').press('Enter');
        await page.getByRole('button', { name: 'Add Reading' }).click();
        await page.locator('#start-date').fill('2023-05-18');
        await page.getByPlaceholder('Enter electricity day reading').click();
        await page.getByPlaceholder('Enter electricity day reading').fill('0');
        await page.getByPlaceholder('Enter electricity night reading').click();
        await page.getByPlaceholder('Enter electricity night reading').fill('0');
        await page.getByPlaceholder('Enter gas reading').click();
        await page.getByPlaceholder('Enter gas reading').fill('0');
        await page.getByRole('button', { name: 'Submit' }).click();
        await expect(page.getByText('Readings entered have to be larger than previous reading!')).toBeVisible()
    });
});