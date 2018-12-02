# What is this

G-Droid can browse the free F-Droid app-repository. It is an alternative client to the F-Droid client.

# Screenshots

<img src="fastlane/metadata/android/en/images/phoneScreenshots/s1.png"  width="320">
<img src="fastlane/metadata/android/en/images/phoneScreenshots/s2.png"  width="320">
<img src="fastlane/metadata/android/en/images/phoneScreenshots/s3.png"  width="320">

# Additional features compared to F-Droid

* star ratings of apps (up to 5 stars) - machine generated metrics
* shows the star upstream star ratings (github, gitlab, sourceforge)
* implements more metrics bases on open source data (like average release cycle time) to generate a star-rating
* let the user choose which metrics are important for him, so there is no 'best app' in the repo - there is only a 'best app' from the point of view of the current user
* shows 'similar apps' when wathcing an app
* show web-site of the app - even if it is 'only a README file on github'. F-Droid has recently removed many websites to punish open source developers who can't effort their own domain.
* showing newest apps and recently updated apps separated
* showing cards in same size for better overview
* ability to 'star' apps to mark them
* showing categories in correct translation (if available) after changing language on the device
* showing screenshots in correct translation
* makes use of larger screens: show actually more apps on tablets
* tags to find apps for standard-tasks easily (email clients, file browsers, text editors), since the F-Droid categories are too broad
* view for 'random apps' to discover apps you usually wouldn't find
* aims to provide many different views to the app repository in order to assist the user to find, what she wants to find and encourage to use more open source apps from the repository
* 'share' apps so it can still be opened with another store (F-Droid, Yalp, Aurora, ...), to get more information about the app.
* different search algorithm
* many more to come (G-Droid is jsut a few weeks old) ...

# Things that G-Droid can NOT do (yet) compared to F-Droid

* uninstall apps
* show or install an older version of an app
* show the permissions correctly translated
* create a local repo, share apps with 'near' people or share apps via bluetooth
* add other repositories than the F-Droid repo
* use the privileged extension
* update autmatically
* http proxy settings
* G-Droid helps you in different ways to find better apps: but in some cases you might still need the 'share' button, to open that app in F-Droid to install it. G-Droid is right now not a complete replacement yet for the F-Droid app.

# Things that are he same in G-Droid and F-Droid

* shows the same apps - G-Droid does not add any apps or modify the builds or download-urls
* all additional meta-data is provided by F-Droid as well (eg. the link to github)
* GPL3 license 

# FAQ

## Where to the ratings com from?

The implementation of the star ratings are not finalised yet. 

For now all that users can do is read the code. It is all open source. You can read on https://gitlab.com/gdroid/gdroiddata/blob/master/env/process_meta_metric.py how to extract metrics out of the f-droid repository. 

Essentially if you look at the F-Droid data you can extract and extrapolate things like:
*  time between software updates
*  age of the software
*  amount of screenshots

Following the source-link that F-Droid provides one can also access the source repo and get metrics
*  amount of code changes
*  code life time
*  contributors races
*  half-life of code blocks
*  ratio of abstract classes to normal classes
*  many other git, code and java metrics

Following the website that F-Droid provides one can also access the ratings that others provide on the upstream (github, gitlab, sourceforge, ...). There you can also, find amount of open bugs, average time to fix a bug or even determine abandoned project. 

And then all of it can be done for each app in the F-Droid repo and compared with each other.

Doing all these things manually is very cumbersome so G-Droid assists in that, to provide a better user experience.

And no. The data does not come from G-Droid users as there is (and will be) no tracking in the app. And is doesn't come from other stores, as that would be irrelevant information and mostly spam that has been bought for money (eg. in Googles play store).
