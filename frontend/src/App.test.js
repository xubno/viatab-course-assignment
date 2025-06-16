import { render, screen } from '@testing-library/react';
import App from './App';

test('renders VIA Tabloid Application header', () => {
  render(<App />);
  const headerElement = screen.getByText(/VIA Tabloid Application/i);
  expect(headerElement).toBeInTheDocument();
});