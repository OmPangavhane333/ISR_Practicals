limport requests
from bs4 import BeautifulSoup
# Set the URL of the website
base_url = 'https://books.toscrape.com/catalogue/category/books/horror_31/index.html'
response = requests.get(base_url)
if response.status_code == 200:
 soup = BeautifulSoup(response.text, 'html.parser')
 product_elements = soup.find_all('article', class_='product_pod')
 for i, product_element in enumerate(product_elements[:10], start=1):
  product_title = product_element.find('h3').a['title']
  product_price = product_element.find('div', class_='product_price').p.text.strip()
  print(f'Product #{i}:')
  print(f'Product Title: {product_title}')
  print(f'Product Price: {product_price}\n')
  print('Successfully scraped data for 10 products from books.toscrape.com')
else:
 print(f'Failed to retrieve the page. Status code: {response.status_code}')
