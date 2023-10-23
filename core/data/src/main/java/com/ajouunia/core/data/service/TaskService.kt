package com.ajouunia.core.data.service

import com.ajouunia.core.data.model.request.CreateTaskRequest
import com.ajouunia.core.data.model.request.ModifyTaskRequest
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskListResponse
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskSortedListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

//"yyyy-MM-dd'T'HH:mm:ss"

interface TaskService {

    @POST("todo")
    suspend fun createTask(
        @Body request: CreateTaskRequest
    ): Response<Unit>

    @PUT("todo/{assignmentId}")
    suspend fun modifyTask(
        @Path("assignmentId") taskId: Long,
        @Body request: ModifyTaskRequest
    ): Response<Unit>

    @DELETE("todo/{assignmentId}")
    suspend fun deleteTask(
        @Path("assignmentId") taskId: Long
    ): Response<Unit>

    @GET("todo/{memberId}")
    suspend fun fetchRemoteUserTaskList(
        @Path("memberId") idToken: Long
    ): Response<List<FetchRemoteUserTaskListResponse>>

    @GET("todo/{memberId}/sorted")
    suspend fun fetchRemoteUserTaskSortedList(
        @Path("memberId") idToken: Long
    ): Response<List<FetchRemoteUserTaskSortedListResponse>>

}