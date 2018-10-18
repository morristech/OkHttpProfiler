# OkHttpProfiler

For activating you need to include library to your android ``build.gradle`` file (module level)

``implementation 'com.itkacher.okhttpprofiler:okhttpprofiler:0.0.1'``
and add Interceptor to okHttpClient

Java

``OkHttpClient mClient = new OkHttpClient.Builder().addInterceptor( new OkHttpProfilerInterceptor() ).build();``
Kotlin

``val client = OkHttpClient.Builder().addInterceptor( new OkHttpProfilerInterceptor() ).build()``

## Then install Android Studio / Intellij IDE plugin

https://plugins.jetbrains.com/plugin/11249-okhttp-profiler

