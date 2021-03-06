package com.sample.todo.data

import androidx.paging.PagedList
import com.sample.todo.domain.entity.Task
import com.sample.todo.main.search.library.domain.entity.SearchResult
import com.sample.todo.main.search.library.domain.entity.SearchResultStatistics
import com.sample.todo.main.statistics.domain.entity.TaskStatistics
import com.sample.todo.main.tasks.library.domain.entity.TaskMini
import io.reactivex.Observable

interface TaskDataSource {
    suspend fun findTaskById(taskId: String): Task?
    suspend fun insert(entity: Task): Long
    suspend fun insertAll(entities: List<Task>): Long
    suspend fun updateComplete(taskId: String, completed: Boolean, updateTime: Long): Long
    suspend fun update(task: Task): Long
    fun getTaskStatisticsObservable(): Observable<TaskStatistics>
    fun tasksCountObservable(): Observable<Long>

    fun getTaskMiniObservablePaged(pageSize: Int): Observable<PagedList<TaskMini>>
    fun getCompletedTaskMiniObservablePaged(pageSize: Int): Observable<PagedList<TaskMini>>
    fun getActiveTaskMiniObservablePaged(pageSize: Int): Observable<PagedList<TaskMini>>
    fun getSearchResultObservablePaged(query: String, pageSize: Int): Observable<PagedList<SearchResult>>
    fun getSearchResultStatisticsObservable(query: String): Observable<SearchResultStatistics>
    fun findByIdObservable(id: String): Observable<List<Task>>
    suspend fun deleteTask(id: String): Long
}
