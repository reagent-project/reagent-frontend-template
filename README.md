# reagent-frontend-template

A [Leiningen](http://leiningen.org/) template for projects using Reagent.

![reagent-template](logo-rounded.jpg)

A Leiningen template for a minimal ClojureScript app based on Reagent. If you wish to create a project with a Clojure backend then consider using the [reagent-template](https://github.com/reagent-project/reagent-template) instead.

#### Requires JDK 1.7+

### Getting Help

For any questions or discussion please come join us at the [Reagent Google Group](https://groups.google.com/forum/#!forum/reagent-project).

## Usage

### shadow-cljs

Create a new application project with shadow-cljs:

```
lein new reagent-frontend <name> +shadow-cljs
```

#### Development mode

To start the app in development mode run:

```
npx shadow-cljs watch app
```

#### Building for production

```
npx shadow-cljs release app
```

### Figwheel

Create a new application project with Figwheel:

```
lein new reagent-frontend <name> +figwheel
```

#### Development mode

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser and see the changes refresh live. Alternatively, you could run `python -m SimpleHTTPServer` in the `public` folder.

#### Building for production

```
lein clean
lein package
```

### REPL

The project is setup to start nREPL on port `7002` once Figwheel starts.
Once you connect to the nREPL, run `(cljs)` to switch to the ClojureScript REPL.


## Contents

The template packages everything you need to create a production ready ClojureScript application following current best practices. The template uses the following features and libraries:

* [Reagent](https://github.com/reagent-project/reagent) - ClojureScript interface to Facebook's React

## Contributing & Customizing

Take a look at the open issues, especially ones marked as `help wanted`. If you see one you'd like to address don't hesitate to start a discussion or submit a pull request.

If the template isn't doing quite what you're looking for, it's easy to create a local copy of your own following these simple steps:

```
git clone https://github.com/reagent-project/reagent-template.git
cd reagent-frontend-template
lein install
```

If you feel that your customizations are general enough to be useful for others then please consider making a pull request.

## Requirements

* JDK 1.7+
* Leiningen 2.x

## License

Copyright © 2015 Dmitri Sotnikov

Distributed under the The MIT License (MIT).
