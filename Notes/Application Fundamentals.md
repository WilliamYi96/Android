Application Fundamentals
@editor William Yi

@date 8.14.2016

The process of how an app runs:

written(java language) --> compile(Android SDK tools) --> APK(an Android package) --> install(.apk file)
APP: Application

APK: Android Package, one APK file contains all the contents of an Android app and is the file that Android-powered devices use to install the app.

API: Application Programming Interface, is a set of routine definitions, protocols, and tools for building software and applications.

protocols: is a set of rules for exchanging information between computers.


Once installed on a device, each Android app lives in its own security sandbox:

The Android operating system assigns each app an unique Linux user ID. Meanwhile, each process has its own VM(virtual machine), so the app code can runs in isolation from other apps.

In this way, the Android system implements the principle of least privilege. It means every app just get the permissions which are needed for itself.


How an app share data with other apps?

Arrange for two apps to share the same Linux user ID (including the same Linux process and the same VM)

Request permission to access device data

App Components

Here are four important types of app components:

what is it?	base class	remark
Activities	An activity represents a single screen with a user interface	Activity	
Services	A service is a component that runs in the background to perform long-running operations or to perform work for remote process	Service	No UI
Content providers	A content provider manages a shared set of app data	ContentProvider	No UI
Broadcast receivers	A broadcast receiver is a component that responds to system-wide broadcast announcements	BroadcastReceiver	No UI
A unique aspect of the Android system is that any app can start another app's component.

An example: if you want the user to capture a photo with the device camera,there's probably another app that does that and your app can use it, instead of developing an activity to capture a photo yourself. You don't need to incorporate or even link to the cod from the camera app. Instead, you can simply start the activity in the camera app that captures a photo. When complete, the photo is even returned to your app so you can use it. To the user, it seems as if the camera is actually a part of your app.


Activating Components

activity, services and broadcast receivers are activated by an asynchronous message called an intent. 

An intent is created with an Intent object. 

An intent can be either explicit or implicit, which means it can define a message to activate either a specific component or a specific type of component. 

content provider is activated when targeted by a request from a ContextResolver.  The component that is performing transactions with the provider doesn't need to and instead calls methods on the ContextResolver object because the content resolver  handles all direct transactions with the content provider.

There are separate methods for activating each type of component, it's functions may seems a little hard to handle, so I will refer to it before long.

Remain to be solved


The Manifest File

Things the Manifest File(AndroidManifest.xml) can do:

Give the existing component to the system

Identify any user permissions the app requires

Declare the minimum API level

Declare hardware and software features required by the app

API libraries the app needs to be linked against

More details: file:///C:/Users/dell1/AppData/Local/Android/sdk/docs/guide/components/fundamentals.html#Manifest


App Resources

An Android app can provide resources separate from your source code.
