import android.util.Log
import com.notation.campusnote.ApiService.Datas.CrawlData
import com.notation.campusnote.ApiService.Datas.LogInData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.notation.campusnote.ApiService.Datas.SignUpData
import com.notation.campusnote.ApiService.Results.CrawlResult
import com.notation.campusnote.ApiService.Results.LogInResult
import com.notation.campusnote.ApiService.Results.RefreashTokenResult
import com.notation.campusnote.ApiService.Results.SignUpResult
import com.notation.campusnote.ApiService.Results.UserResult

object RestHelper {

    fun <T> restHelper(call: Call<T>, callback: (result: T?) -> Unit) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    val output = response.body()
                    if (output != null) {
                        Log.d("REST 테스팅", "REST Success, output: $output")
                        callback(output)
                    } else {
                        // Handle null response
                        Log.e("REST 테스팅", "Error: Response Body is null")
                        callback(null)
                    }
                } else {
                    // Handle error
                    Log.e("REST 테스팅", "Error: ${response.code()} - ${response.message()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                // Handle failure
                Log.e("REST 테스팅", "Error: ${t.message}")
                callback(null)
            }
        })
    }

    fun postKakaosignUp(data: SignUpData, callback: (result: SignUpResult?) -> Unit) {
        restHelper(ApiClient.apiService.postSignUp(data), callback)
    }

    fun postRefreashToken(callback: (result: RefreashTokenResult?) -> Unit) {
        restHelper(ApiClient.apiService.postRefreshToken(), callback)
    }

    fun postCrawl(data: CrawlData, callback: (result: CrawlResult?) -> Unit) {
        restHelper(ApiClient.apiService.postCrawl(data), callback)
    }

    fun postKakaologIn(data: LogInData, callback: (result: LogInResult?) -> Unit) {
        restHelper(ApiClient.apiService.postLogin(data), callback)
    }

    fun getUser(callback: (result: UserResult?) -> Unit) {
        restHelper(ApiClient.apiService.getUser(), callback)
    }


    }