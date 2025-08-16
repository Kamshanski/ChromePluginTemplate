Contains utils to create reusable html elements

- `CustomHtmlElement`
    - Allows to create any custom HTML element.
    - Element setup happens in loadContent function.
- `CustomHtmlInflatedElement`
    - Allows to create custom HTML element from HTML file.
    - Path to HTML file is required. Base class loads HTML file asynchronously and then inserts HTML text to innerHTML. 
    - When innerHTML is set, onHtmlContentLoaded is immediately called.
    - HTML page is loaded each time component connects to document. No caching implemented

Use ElementFactory to conveniently register element and setup its tag. ElementFactory require `register()` call at the start of an app

Credentials https://avwie.github.io/web-components-in-kotlin