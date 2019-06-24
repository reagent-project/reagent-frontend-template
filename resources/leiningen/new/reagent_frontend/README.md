
### Development mode
{{#shadow-cljs-hook?}}
```
npm install
npx shadow-cljs watch app
```
start a ClojureScript REPL
```
npx shadow-cljs browser-repl
```
{{/shadow-cljs-hook?}}
{{#figwheel-hook?}}
To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.

### REPL

The project is setup to start nREPL on port `7002` once Figwheel starts.
Once you connect to the nREPL, run `(cljs)` to switch to the ClojureScript REPL.

### Building for production

```
lein clean
lein package
```
{{/figwheel-hook?}}
{{#shadow-cljs-hook?}}
### Building for production

```
npx shadow-cljs release app
```
{{/shadow-cljs-hook?}}
