# RisingLog

Simple logger for android

## Usage

### Gradle:
project gradle:
```xml
allprojects {
    repositories {
        maven { url "https://www.jitpack.io" }
    }
}
```
app gradle:
```xml
dependencies {
    implementation 'com.github.risingpark:risinglog:1.0.0'
}
```

### Attributes
|Attributes|format|describe
|---|---|---|
|TAG|string| logging tag(default = RisingLog)
|isDebug|boolean| debug mode(default = true)
|isShowClassMethod|boolean| show name of Class And Method(default = true)

### In code

Use
```kotlin
RisingLog.d("debug")
RisingLog.e("error")
RisingLog.w("warning")
RisingLog.i("information")
RisingLog.v("verbose")
```

Method for tag
```kotlin
RisingLog.d("TAG","Hello RisingLog")
```

(option) Initialize in Kotlin
```kotlin
RisingLog.apply {
            TAG = "RisingLog"
            isDebug = true
            isShowClassMethod = true
        }
```



# License
```xml
Copyright 2020 RisingPark

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
