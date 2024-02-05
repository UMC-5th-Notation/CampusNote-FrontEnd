import com.notation.campusnote.ApiService.Datas.CrawlData
import com.notation.campusnote.ApiService.Datas.LogInData
import retrofit2.Call
import retrofit2.http.*
import com.notation.campusnote.ApiService.Datas.SignUpData
import com.notation.campusnote.ApiService.Results.CrawlResult
import com.notation.campusnote.ApiService.Results.LogInResult
import com.notation.campusnote.ApiService.Results.RefreashTokenResult
import com.notation.campusnote.ApiService.Results.SignUpResult
import com.notation.campusnote.ApiService.Results.UserResult

data class Post(
    val data: Any // 또는 다른 적절한 타입으로 지정할 수 있음
)

data class SignUpRequest(
    val clientId: String,
    val name: String,
    val university: String,
    val semester: String,
    val img: String
)

interface ApiService {

    @POST("api/v1/crawl")
    fun postCrawl(@Body data: CrawlData): Call<CrawlResult>

    @POST("api/v1/auth/refresh-token")
    fun postRefreshToken(): Call<RefreashTokenResult>

    @POST("api/v1/auth/signUp")
    fun postSignUp(@Body data: SignUpData): Call<SignUpResult>

    @POST("api/v1/login")
    fun postLogin(@Body data: LogInData): Call<LogInResult>

    @GET("api/v1/user")
    fun getUser(): Call<UserResult>
}
