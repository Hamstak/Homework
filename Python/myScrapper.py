import request as r
import urllib3 as urllib

_URL = 'https://reddit.com/'
_header = {'User-agent': 'myscript'}

request = Request (_URL, _header)
response = urlopen(request)
data = response.read()
print(data)
